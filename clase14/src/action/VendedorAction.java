
package action;

import java.util.List;

import model.Vendedor;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ParentPackage;

import service.VendedorService;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
@ParentPackage("dawi")
public class VendedorAction  extends ActionSupport{
	
	public  List<Vendedor>lstVendedor;
	

	@Action(value = "/grafico", results =
		{ @Result(name = "ok", type = "jasper", params = {"location", "/reportes/grafico.jasper",
			"dataSource",
			"lstVendedor", "format", "PDF", }) })

	
	
	public String listado(){
		
		VendedorService service=new VendedorService();
		lstVendedor=service.listado();
		if(lstVendedor==null){
			addActionError("error al listar");
			return "error";
			
			
	
		}else  {
			addActionMessage("lisatado");
			return "ok";
			// TODO: handle exception
		}
		
		
	}
	
	
	
	

	public List<Vendedor> getLstVendedor() {
		return lstVendedor;
	}

	public void setLstVendedor(List<Vendedor> lstVendedor) {
		this.lstVendedor = lstVendedor;
	}
	

}
