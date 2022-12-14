package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsGeneralInformationDAO;
import ph.edu.up.antech.dao.pagination.ZolPerDoorsGeneralInformationPaginationDAO;
import ph.edu.up.antech.domain.master.config.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ZolPerDoorsGeneralInformationServiceImpl implements ZolPerDoorsGeneralInformationService {

    @Autowired
    private ZolPerDoorsGeneralInformationDAO zolPerDoorsGeneralInformationDAO;

    @Autowired
    private ZolPerDoorsGeneralInformationPaginationDAO zolPerDoorsGeneralInformationPaginationDAO;

    @Override
    public ZolPerDoorsGeneralInformation saveZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        return zolPerDoorsGeneralInformationDAO.saveZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode) {
        return zolPerDoorsGeneralInformationDAO.findZolPerDoorsGeneralInformationByItemCode(itemCode);
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByZpcItemCode(String zpcItemCode) {
        return zolPerDoorsGeneralInformationDAO.findZolPerDoorsGeneralInformationByZpcItemCode(zpcItemCode);
    }

    @Override
    public List<ZolPerDoorsGeneralInformation> findAllZolPerDoorsGeneralInformation() {
        return zolPerDoorsGeneralInformationDAO.findAllZolPerDoorsGeneralInformation();
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationById(Integer id) {
        return zolPerDoorsGeneralInformationDAO.findZolPerDoorsGeneralInformationById(id);
    }

    @Override
    public ZolPerDoorsGeneralInformation updateZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        return zolPerDoorsGeneralInformationDAO.updateZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);
    }

    @Override
    public void removeZolPerDoorsGeneralInformation(Integer id) {
        zolPerDoorsGeneralInformationDAO.removeZolPerDoorsGeneralInformation(id);
    }

    @Override
    public Page<ZolPerDoorsGeneralInformation> findAll(Pageable pageable) {
        return zolPerDoorsGeneralInformationPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<ZolPerDoorsGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return zolPerDoorsGeneralInformationPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
