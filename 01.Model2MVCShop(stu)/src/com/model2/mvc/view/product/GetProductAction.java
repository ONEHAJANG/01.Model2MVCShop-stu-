package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class GetProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
	//	request.getParameter("ProdNo");
		
	//	int prodno = Integer.parseInt(request.getParameter("ProdNo"));
		
		String prodno = request.getParameter("prodNo");
		
		ProductService service=new ProductServiceImpl();
		
		
		ProductVO vo = service.getProduct(Integer.parseInt(prodno));
		System.out.println("GetProductAction 27Line :" +vo);
		
		request.setAttribute("vo", vo);
		
		if("manage".equals(request.getParameter("menu"))) {
			return "forward:/product/updateProductView.jsp";
		}else{
		return "forward:/product/getProduct.jsp";
		}
	}
}