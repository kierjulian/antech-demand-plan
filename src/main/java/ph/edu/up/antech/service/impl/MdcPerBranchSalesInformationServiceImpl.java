package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;
import ph.edu.up.antech.service.MdcPerBranchSalesInformationService;

import java.util.List;

@Service
public class MdcPerBranchSalesInformationServiceImpl implements MdcPerBranchSalesInformationService {

    @Autowired
    private MdcPerBranchSalesInformationDAO mdcPerBranchSalesInformationDAO;

    @Override
    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        return mdcPerBranchSalesInformationDAO.saveMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
    }

    @Override
    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation() {
        return mdcPerBranchSalesInformationDAO.findAllMdcPerBranchSalesInformation();
    }

}
