package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;

public interface ZolMdcAccountService {

    public ZolMdcAccount createZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn);

}
