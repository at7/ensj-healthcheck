/*
 * Copyright [1999-2015] Wellcome Trust Sanger Institute and the EMBL-European Bioinformatics Institute
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.ensembl.healthcheck.testcase.compara;

import java.sql.Connection;

import org.ensembl.healthcheck.DatabaseRegistryEntry;
import org.ensembl.healthcheck.ReportManager;
import org.ensembl.healthcheck.Team;
import org.ensembl.healthcheck.testcase.SingleDatabaseTestCase;

/**
 * An EnsEMBL Healthcheck test case to check for "threshold_on_ds" in the
 * method_link_species_set_tag table
 */

public class MLSSTagThresholdDs extends SingleDatabaseTestCase {

	public MLSSTagThresholdDs() {
		setDescription("Tests that proper 'threshold_on_ds' entries are in method_link_species_set_tag.");
		setTeamResponsible(Team.COMPARA);
	}

	public boolean run(DatabaseRegistryEntry dbre) {

		Connection con = dbre.getConnection();

		if (!tableHasRows(con, "homology")) {
			ReportManager.problem(this, con, "NO ENTRIES in homology or homology_member tables");
			return false;
		}

		boolean result = true;
		result &= checkCountIsNonZero(con, "method_link_species_set_tag", "tag = 'threshold_on_ds'");
		result &= checkCountIsZero(con, "method_link_species_set_tag", "tag='threshold_on_ds' AND value NOT IN (1,2)");
		return result;
	}

}
