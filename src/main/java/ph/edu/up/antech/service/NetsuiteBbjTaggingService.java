package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

import java.util.List;

public interface NetsuiteBbjTaggingService {

    public NetsuiteBbjTagging saveNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging();

    public NetsuiteBbjTagging findNetsuiteBbjTaggingById(Integer id);

    public NetsuiteBbjTagging updateNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public void removeNetsuiteBbjTagging(Integer id);

    public Page<NetsuiteBbjTagging> findAll(Pageable pageable);

    public Page<NetsuiteBbjTagging> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
