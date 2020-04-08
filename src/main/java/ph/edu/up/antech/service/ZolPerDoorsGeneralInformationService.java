package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.ZolPerDoorsGeneralInformation;

import java.util.List;

public interface ZolPerDoorsGeneralInformationService {

    public ZolPerDoorsGeneralInformation saveZolPerDoorsGeneralInformation(
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByZpcItemCode(String zpcItemCode);

    public List<ZolPerDoorsGeneralInformation> findAllZolPerDoorsGeneralInformation();

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationById(Integer id);

    public ZolPerDoorsGeneralInformation updateZolPerDoorsGeneralInformation(
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public void removeZolPerDoorsGeneralInformation(Integer id);

    public Page<ZolPerDoorsGeneralInformation> findAll(Pageable pageable);

    public Page<ZolPerDoorsGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
