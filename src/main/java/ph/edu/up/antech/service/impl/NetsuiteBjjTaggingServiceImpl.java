package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteBjjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBjjTagging;
import ph.edu.up.antech.service.NetsuiteBjjTaggingService;

import java.util.List;

@Service
public class NetsuiteBjjTaggingServiceImpl implements NetsuiteBjjTaggingService {

    @Autowired
    private NetsuiteBjjTaggingDAO netsuiteBjjTaggingDAO;

    @Override
    public NetsuiteBjjTagging createNetsuiteBjjTagging(NetsuiteBjjTagging netsuiteBjjTagging) {
        return netsuiteBjjTaggingDAO.createNetsuiteBjjTagging(netsuiteBjjTagging);
    }

    @Override
    public List<NetsuiteBjjTagging> findAllNetsuiteBjjTagging() {
        return netsuiteBjjTaggingDAO.findAllNetsuiteBjjTagging();
    }

}
