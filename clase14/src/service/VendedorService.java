package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Vendedor;
import mybatis.MyBatisUtil;
import mybatis.mapper.ProductoMapper;
import mybatis.mapper.VendedorMapper;

public class VendedorService  {

	public List<Vendedor> listado() {
		SqlSession session=MyBatisUtil.getSqlSessionFactory().openSession();
		List<Vendedor>lista=null;
		try {
			VendedorMapper pm = session.getMapper(VendedorMapper.class);
			lista = pm.listado();
		} catch (Exception e){
			
		} finally {
			session.close();
		}
		return lista;
	}
	}


