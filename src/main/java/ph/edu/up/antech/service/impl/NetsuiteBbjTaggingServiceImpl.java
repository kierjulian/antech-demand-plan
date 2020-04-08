package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteBbjTaggingDAO;
import ph.edu.up.antech.dao.pagination.NetsuiteBbjTaggingPaginationDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteBbjTagging;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NetsuiteBbjTaggingServiceImpl implements NetsuiteBbjTaggingService {

    @Autowired
    private NetsuiteBbjTaggingDAO netsuiteBbjTaggingDAO;

    @Autowired
    private NetsuiteBbjTaggingPaginationDAO netsuiteBbjTaggingPaginationDAO;

    @Override
    public NetsuiteBbjTagging saveNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        return netsuiteBbjTaggingDAO.saveNetsuiteBbjTagging(netsuiteBbjTagging);
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

    @Override
    public Page<NetsuiteBbjTagging> findAll(Pageable pageable) {
        return netsuiteBbjTaggingPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<NetsuiteBbjTagging> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return netsuiteBbjTaggingPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
