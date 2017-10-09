package com.vcooline.crm.admin;


import com.vcooline.crm.admin.service.*;
import com.vcooline.crm.common.DataSourceConfig;
import com.vcooline.crm.common.enumutil.*;
import com.vcooline.crm.common.model.*;
import com.vcooline.crm.common.utils.RandomUtils;
import com.vcooline.crm.common.utils.StringUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfig.class, WebConfig.class})
@WebAppConfiguration
@IntegrationTest("server.port:3005")
public class ApplicationTests {

    @Autowired
    private CrmClueService clueService;

    @Autowired
    private CrmReleCustService custService;

    @Autowired
    private CrmCustomerService customerService;

    @Autowired
    private CrmProductService productService;

    @Autowired
    private CrmClueProductService clueProductService;

    @Autowired
    private CrmProductVersionService versionService;

    /**
     * 新增产品测试
     */
    @Test
    @Ignore
    public void testAddProduct() {
        String[] proName = {"V系列", "红包运营商", "红包广告主", "商业地产", "易站", "优者工作圈", "定制开发", "其他"};
        for (String name : proName) {
            CrmProduct product = new CrmProduct();
            product.setProductName(name);
            product.setProductStatus(CrmProductStatusEnum.PRODUCT_SHELVES.getCode());
            product.setProductPrice((long) (Math.random() * 100));
            product.setCreateTime(new Date());
            System.out.println(product.toString());
            int result = productService.insertSelective(product);
            Assert.assertEquals(1, result);
        }
    }

    @Test
    @Ignore
    public void testGetMaxCode() {
        Integer result = clueService.getMaxNumCode();
        Assert.assertNull(result);
    }

    /**
     * 测试新增线索
     */
    @Test
    @Ignore
    public void testAddClue() {
        //保存客户线索信息
        //客户信息begin
        CrmClue clue = new CrmClue();
        clue.setCustName("上海微客来信息技术有限公司");
        clue.setCustAddr("张江高科技园区郭守敬路498号22幢305室");
        clue.setCustProvince(9);
        clue.setCustCity(73);
        clue.setCustArea(732);
        //客户信息end
        //线索基本信息begin
        clue.setAdminId((long) 1);
        clue.setAdminName("xinbj");
        clue.setClueSource(ClueSourceEnum.SYS_SPLIT.getCode());
        clue.setClueKnow(ClueKnowEnum.PC.getCode());
        clue.setClueConsult(ClueConsultEnum.FREE.getCode());
        clue.setClueType(ClueTypeEnum.PROXY.getCode());
        Integer numCode = clueService.getMaxNumCode();
        clue.setNumCode(numCode);
        clue.setClueNumber(StringUtils.generateClueNumber(numCode));
        //线索基本信息end
        //保存线索begin
        int clueResult = clueService.insertSelective(clue);
        Assert.assertEquals(1, clueResult);
        //保存线索end
        //关联客户联系人信息begin
        String[] jobs = {"销售", "采购"};
        int i = 0;
        for (String job : jobs) {
            CrmCustomer customer1 = new CrmCustomer();
            customer1.setCustName("辛保健" + (++i));
            customer1.setCustJob("销售");
            customer1.setCustRole(CustRoleEnum.values()[RandomUtils.RandomByInterval(0, CustRoleEnum.values().length - 1)].getCode());
            customer1.setCustPhone("1522101644" + RandomUtils.RandomByInterval(11, 99));
            customer1.setCustQq("" + RandomUtils.RandomByInterval(13383403, 134238429));
            customer1.setCustEmail(customer1.getCustQq() + "@qq.com");
            int custResult = customerService.insertSelective(customer1);
            Assert.assertEquals(1, custResult);
            CrmReleCust clueCust = new CrmReleCust();
            clueCust.setTargetId(clue.getId());
            clueCust.setReleType(ReleTypeEnum.CLUE_TYPE.getCode());
            clueCust.setCustId(customer1.getId());
            clueCust.setCreateTime(new Date());
            int cluecustResult = custService.insertSelective(clueCust);
            Assert.assertEquals(1, cluecustResult);
        }
        //关联客户联系人信息end
        //保存产品信息begin
        CrmClueProduct clueProduct = new CrmClueProduct();
        clueProduct.setClueId(clue.getId());
        clueProduct.setProductId((long) 1);
        int clueProResult = clueProductService.insertSelective(clueProduct);
        Assert.assertEquals(1, clueProResult);
        //保存产品信息end

    }

    @Test
    @Ignore
    public void testAddProVersion() {
//		proid v系列 1  易站 5
        String[] vs = {"V领先", "V门户", "V加粉"};
        for (String v : vs) {
            CrmProductVersion version = new CrmProductVersion();
            version.setProdId(1l);
            version.setVersName(v);
            version.setVersPrice(100l);
            int result = versionService.insertSelective(version);
            Assert.assertEquals(1, result);
        }
        CrmProductVersion version = new CrmProductVersion();
        version.setProdId(5l);
        version.setVersName("易站普通版");
        version.setVersPrice(100l);
        int result = versionService.insertSelective(version);
        Assert.assertEquals(1, result);
    }
}