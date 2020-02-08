package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

import java.util.List;

public interface NetsuiteBbjTaggingDAO {

    public NetsuiteBbjTagging createNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging();

}
