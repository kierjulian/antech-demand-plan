package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.NetsuiteBbjTagging;

import java.util.List;

public interface NetsuiteBbjTaggingDAO {

    public NetsuiteBbjTagging saveNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging();

    public NetsuiteBbjTagging findNetsuiteBbjTaggingById(Integer id);

    public NetsuiteBbjTagging updateNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging);

    public void removeNetsuiteBbjTagging(Integer id);

}
