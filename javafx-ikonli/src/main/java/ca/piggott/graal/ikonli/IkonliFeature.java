/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.ikonli;

import java.util.List;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.Feature.BeforeAnalysisAccess;

import ca.piggott.graal.support.FeatureSupport;

public class IkonliFeature
		extends FeatureSupport
		implements Feature {

	@Override
	public void beforeAnalysis(BeforeAnalysisAccess access) {
		registerAccess(access, JNI);
	}

    private static final List<String> JNI = List.of(
        "org.kordamp.ikonli.feather.FeatherIkonHandler",
        "org.kordamp.ikonli.feather.FeatherIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignAIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignBIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignCIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignDIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignEIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignFIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignGIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignHIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignIIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignJIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignKIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignLIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignMIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignNIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignOIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignPIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignQIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignRIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignSIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignTIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignUIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignVIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignWIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignXIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignYIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignZIkonHandler",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignAIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignBIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignCIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignDIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignEIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignFIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignGIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignHIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignIIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignJIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignKIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignLIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignMIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignNIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignOIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignPIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignQIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignRIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignSIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignTIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignUIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignVIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignWIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignXIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignYIkonProvider",
        "org.kordamp.ikonli.materialdesign2.MaterialDesignZIkonProvider",
        "org.kordamp.ikonli.material2.Material2ALIkonHandler",
        "org.kordamp.ikonli.material2.Material2MZIkonHandler",
        "org.kordamp.ikonli.material2.Material2OutlinedALIkonHandler",
        "org.kordamp.ikonli.material2.Material2OutlinedMZIkonHandler",
        "org.kordamp.ikonli.material2.Material2RoundALIkonHandler",
        "org.kordamp.ikonli.material2.Material2RoundMZIkonHandler",
        "org.kordamp.ikonli.material2.Material2SharpALIkonHandler",
        "org.kordamp.ikonli.material2.Material2SharpMZIkonHandler",
        "org.kordamp.ikonli.material2.Material2ALIkonProvider",
        "org.kordamp.ikonli.material2.Material2MZIkonProvider",
        "org.kordamp.ikonli.material2.Material2OutlinedALIkonProvider",
        "org.kordamp.ikonli.material2.Material2OutlinedMZIkonProvider",
        "org.kordamp.ikonli.material2.Material2RoundALIkonProvider",
        "org.kordamp.ikonli.material2.Material2RoundMZIkonProvider",
        "org.kordamp.ikonli.material2.Material2SharpALIkonProvider",
        "org.kordamp.ikonli.material2.Material2SharpMZIkonProvider"
        );
}
