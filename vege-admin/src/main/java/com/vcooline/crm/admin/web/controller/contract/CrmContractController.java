package com.vcooline.crm.admin.web.controller.contract;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

import com.vcooline.crm.admin.service.CrmContractFileService;
import com.vcooline.crm.common.enumutil.FileTypeEnum;
import com.vcooline.crm.common.model.CrmContractFile;
import com.vcooline.crm.common.utils.FileUtils;
import com.vcooline.crm.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vcooline.crm.admin.service.impl.CrmContractServiceImpl;
import com.vcooline.crm.admin.service.impl.CrmProductVersionServiceImpl;
import com.vcooline.crm.admin.web.controller.BaseController;
import com.vcooline.crm.common.enumutil.ContractStatusEnum;
import com.vcooline.crm.common.enumutil.ContractTypeEnum;
import com.vcooline.crm.common.enumutil.UnGatheringEnum;
import com.vcooline.crm.common.model.CrmContract;
import com.vcooline.crm.common.model.Page;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("contract")
@Controller
public class CrmContractController extends BaseController {

	@Autowired
	private CrmContractServiceImpl crmContractServiceImpl;
	
	@Autowired
	private CrmProductVersionServiceImpl crmProductVersionServiceImpl;

	@Autowired
	private CrmContractFileService fileService;

	@Value("${file.upload.path}")
	private String filePath;
	 
	@RequestMapping("contractPage")
	public String CrmContract(CrmContract contract,Model model,Integer pageNo,Integer pageSize){
		
		Page<CrmContract> page = new Page<CrmContract>(); 
		if(pageNo != null){
			page.setPageNo(pageNo);
		}
		if(pageSize != null){
			page.setPageSize(pageSize);
		}
		page = crmContractServiceImpl.getCrmContractList(page,contract);
		model.addAttribute("page", page);
		model.addAttribute("contract", contract);
		model.addAttribute("statusEnum", ContractStatusEnum.toList());
		model.addAttribute("versions", crmProductVersionServiceImpl.getVersionList());
		model.addAttribute("typeEnum", ContractTypeEnum.toList());
		model.addAttribute("unGatheringEnum", UnGatheringEnum.toList());
		return "html/contract/contract";
	}
	
	/**
	  * @Description:根据id查询合同详细信息
	  * @param id
	  * @return CrmContract    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月3日 上午10:28:52
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("selectContractInfoById")
	public  CrmContract selectContractInfoById(Long id){
		CrmContract contract = crmContractServiceImpl.selectContractInfoById(id);
		return contract;
	}
	
	/**
	  * @Description:合同审核操作
	  * @param contract
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月3日 上午11:56:05
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("contractAudit")
	public String contractAudit(CrmContract contract){
		crmContractServiceImpl.updateContractById(contract);
		return "redirect:/contract/contractPage";
	}
	
	/**
	  * @Description:合同账号开通操作
	  * @param contract
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月3日 上午11:56:05
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("contractAcc")
	public String contractAcc(CrmContract contract){
		crmContractServiceImpl.updateContractById(contract);
		return "redirect:/contract/contractPage";
	}
	
	/**
	  * @Description:合同作废操作
	  * @param contract
	  * @return String    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月3日 上午11:56:05
	  * 上海微客来软件技术有限公司
	 */
	@ResponseBody
	@RequestMapping("contractCancel")
	public int contractCancel(CrmContract contract){
		return crmContractServiceImpl.updateContractById(contract);
	}

	/**
	  * @Description:下载文件
	  * @param @param fileName 
	  * @return void    返回类型
	  * @throws
	  * @author caohuan
	  * @date 2015年8月5日 下午5:29:49
	  * 上海微客来软件技术有限公司
	 */
	@RequestMapping("downLoad")   
    public void downLoad(HttpServletResponse response,Long id){
        CrmContractFile contractFile = new CrmContractFile();
        contractFile.setFileType(FileTypeEnum.CONTRACT_FILE.getCode());
        contractFile.setTargetId(id);
		List<CrmContractFile> fileList = fileService.selectByTypeTargetId(contractFile);

        CrmContract contract = crmContractServiceImpl.selectByPrimaryKey(id);
        String zipFilePath = null;
        if (StringUtils.isEmpty(contract.getContAccessoryName())){
            logger.info("文件未被压缩过，开始压缩文件。。。");
            List<String> fileNames = new ArrayList<>();
            for (int i = 0;i<fileList.size();i++) {
                fileNames.add(filePath+fileList.get(i).getFileName());
                logger.info(String.format("压缩的文件为：%d -- %s",i,filePath+fileList.get(i).getFileName()));
            }
            zipFilePath = filePath + contract.getContNumber() + ".zip";
            logger.info(String.format("压缩文件的路径为：%s",zipFilePath));
            boolean zipResult = FileUtils.ZipFiles(fileNames, zipFilePath);
            logger.info("文件压缩是否成功:"+zipResult);
            if (zipResult){//压缩成功
                contract.setContAccessoryName(zipFilePath);
                crmContractServiceImpl.updateByPrimaryKeySelective(contract);
            }
        }else{
            zipFilePath = contract.getContAccessoryName();
            logger.info(String.format("文件已经压缩过，存储路径为：%s",zipFilePath));
        }


        BufferedInputStream br = null;
        OutputStream out = null;
        try {
            File f = new File(zipFilePath);
            logger.info("下载文件服务器路径：" + zipFilePath);
            if (!f.exists()) {
                response.sendRedirect("/err");
                return;
            }
            br = new BufferedInputStream(new FileInputStream(f));

            byte[] buf = new byte[1024];
            int len = 0;

            response.reset(); // 非常重要
            // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(f.getName().getBytes("gb2312"), "iso8859-1"));

            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            logger.info("下载合同文件" + e);
        } finally {
            try {
                if (br != null)
                    br.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                logger.info(e.getMessage());
            }
        }

    }   

	/**
	 * 根据名字获取合同
	 * @param contractNumber
	 * @return
	 */
	@RequestMapping("/getContractByNumber")
	@ResponseBody
	public List<String> getContractByNumber(String contractNumber){
		List<String> contractNames = crmContractServiceImpl.getContractName(contractNumber);
		return contractNames;
	}

	/**
	 * 根据名字获取合同
	 * @param contractNumber
	 * @return
	 */
	@RequestMapping("/getContract")
	@ResponseBody
	public CrmContract getContract(String contractNumber){
		CrmContract contract = crmContractServiceImpl.getContractByNumber(contractNumber);
		return contract;
	}

}
