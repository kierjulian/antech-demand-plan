package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBjjTagging;

import java.util.List;

public interface NetsuiteBjjTaggingService {

    public NetsuiteBjjTagging createNetsuiteBjjTagging(NetsuiteBjjTagging netsuiteBjjTagging);

    public List<NetsuiteBjjTagging> findAllNetsuiteBjjTagging();

}
