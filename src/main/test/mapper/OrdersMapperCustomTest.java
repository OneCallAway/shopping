package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import po.Orders;
import po.OrdersCustom;
import po.User;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

import static org.testng.Assert.*;

public class OrdersMapperCustomTest {
    private SqlSessionFactory sqlSessionFactory;

    @BeforeMethod
    public void setUp() throws Exception {
        //获取配置文件
        String resource = "config/SqlMapConfig.xml";
        //获取流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建代理对象
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

        System.out.println(list);

        sqlSession.close();

    }


    @Test
    public void testFindOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserLazyLoadingResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoadingResultMap();

//        遍历订单列表
        for (Orders orders : list) {
            /** 
            * @author OneCallAway 18-4-3 
            * @time 下午4:11 
            * @method testFindOrdersUserLazyLoadingResultMap 
            * @param [] 
            * @return void 
            * @version V1.0.0 
            * @description 执行getUser()去查询用户信息,实现按需加载 
            */
            User user = orders.getUser();
            System.out.println(user);
        }
        sqlSession.close();
    }
}