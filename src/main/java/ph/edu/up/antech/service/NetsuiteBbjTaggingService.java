package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

import java.util.List;

public interface NetsuiteBbjTaggingService {

    public NetsuiteBbjTagging createNetsuiteBjjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging();

}