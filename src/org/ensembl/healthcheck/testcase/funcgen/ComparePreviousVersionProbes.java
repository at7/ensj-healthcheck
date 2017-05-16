package org.ensembl.healthcheck.testcase.funcgen;

import java.util.Map;

import org.ensembl.healthcheck.DatabaseRegistryEntry;
import org.ensembl.healthcheck.Team;
import org.ensembl.healthcheck.testcase.generic.ComparePreviousVersionBase;

public class ComparePreviousVersionProbes extends ComparePreviousVersionBase {

    public ComparePreviousVersionProbes() {
        setTeamResponsible(Team.FUNCGEN);
        setDescription("Checks for loss of Probes between database versions");
    }
    @Override
    protected Map getCounts(DatabaseRegistryEntry dbre) {
      return getCountsBySQL(dbre, "select array.name, count(distinct probe_id) from array join array_chip using (array_id) join probe using (array_chip_id) group by array.name order by array.name");
    }

    @Override
    protected String entityDescription() {
        return "Probes";
    }
    @Override
    protected double threshold() {
        return 1;
    }
    @Override
    protected boolean testUpperThreshold(){
        return true;
    }

    @Override
    protected double minimum() {
      return 0;
    }
}
