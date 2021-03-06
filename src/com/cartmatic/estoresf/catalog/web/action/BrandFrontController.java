package com.cartmatic.estoresf.catalog.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cartmatic.estore.catalog.service.BrandManager;
import com.cartmatic.estore.common.model.catalog.Brand;
import com.cartmatic.estore.core.controller.GenericStoreFrontController;
/**
 * @TODO 暂时没有使用
 * @author kedou
 *
 */
@Controller
public class BrandFrontController  extends GenericStoreFrontController<Brand>{
	private BrandManager brandManager = null;

    public void setBrandManager(BrandManager inMgr) {
        this.brandManager = inMgr;
    }
    
	@Override
	protected void initController() throws Exception {
		// TODO Auto-generated method stub
		mgr = brandManager;
		setCacheSecondsConfigurable(true);
	}
	
	@Override
	@RequestMapping(value="/designer/index.html")
	public ModelAndView defaultAction(HttpServletRequest request,HttpServletResponse response) {
		//String template=request.getParameter("template");
		ModelAndView mv=new ModelAndView("catalog/designer");
		List<Brand> brandList=brandManager.findAllBrands();
		mv.addObject("brandList", brandList);
		return mv;
	}
	
}
