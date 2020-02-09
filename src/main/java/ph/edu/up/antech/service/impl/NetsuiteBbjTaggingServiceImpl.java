package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteBbjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;

import java.util.List;

@Service
public class NetsuiteBbjTaggingServiceImpl implements NetsuiteBbjTaggingService {

    @Autowired
    private NetsuiteBbjTaggingDAO netsuiteBbjTaggingDAO;

    @Override
    public NetsuiteBbjTagging createNetsuiteBjjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        return netsuiteBbjTaggingDAO.createNetsuiteBbjTagging(netsuiteBbjTagging);
    }

    @Override
    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging() {
        return netsuiteBbjTaggingDAO.findAllNetsuiteBbjTagging();
    }

    @Override
    public NetsuiteBbjTagging findNetsuiteBbjTaggingById(Integer id) {
        return netsuiteBbjTaggingDAO.findNetsuiteBbjTaggingById(id);
    }

    @Override
    public NetsuiteBbjTagging updateNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        return netsuiteBbjTaggingDAO.updateNetsuiteBbjTagging(netsuiteBbjTagging);
    }

    @Override
    public void removeNetsuiteBbjTagging(Integer id) {
        netsuiteBbjTaggingDAO.removeNetsuiteBbjTagging(id);
    }

}
