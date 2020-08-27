/*
** ComputeIActionversion 1.0.
**
** Copyright (c) 2020 Oracle, Inc.
** Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.
*/

package com.example.fn;

import com.fnproject.fn.api.InputBinding;
import com.oracle.bmc.auth.ResourcePrincipalAuthenticationDetailsProvider;
import com.oracle.bmc.core.ComputeClient;
import com.oracle.bmc.core.requests.InstanceActionRequest;
import com.oracle.bmc.core.responses.InstanceActionResponse;
import com.oracle.bmc.core.responses.GetInstanceResponse;
import com.oracle.bmc.core.requests.GetInstanceRequest;


public class ComputeAction {

    private final String instanceOCID = "ocid1.instance.oc1.sa-saopaulo-1.antxeljreun4owycjo4zqglpdojetv4intkit36zaklhsigqujpqcfsnnxba";
    private ComputeClient computeClient = null;
    final ResourcePrincipalAuthenticationDetailsProvider provider
            = ResourcePrincipalAuthenticationDetailsProvider.builder().build();

    public ComputeAction() {

        try {

            computeClient = new ComputeClient(provider);

        } catch (Throwable ex) {
            System.err.println("Failed to instantiate ComputeClient - " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String handle(String action) {

        String idInstance = "teste";

        if (computeClient == null) {
            System.err.println("There was a problem creating the ComputeClient object. Please check logs...");
            return idInstance;
        }

        try {
            InstanceActionRequest request = InstanceActionRequest.builder().action(action).instanceId(instanceOCID).build();
            InstanceActionResponse response = computeClient.instanceAction(request);
            idInstance = response.getInstance().getId();
            idInstance.concat(action);

        } catch (Throwable e) {
            System.err.println("e.getMessage() " + e.getMessage());
            e.printStackTrace();
            idInstance = e.getMessage() + "erro";
        }

        return idInstance;
    }
}
