package io.bootique.test.junit;

import com.google.inject.Module;
import io.bootique.BQRuntime;
import io.bootique.meta.module.ModuleMetadata;
import io.bootique.meta.module.ModulesMetadata;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

/**
 * A helper class for writing test assertions against a {@link BQRuntime}.
 *
 * @since 0.25
 */
public class BQRuntimeChecker {

    /**
     * Verifies that runtime contains expected modules.
     *
     * @param runtime         a Bootique runtime whose contents we are testing.
     * @param expectedModules a vararg array of expected module types.
     */
    public static void testModulesLoaded(BQRuntime runtime, Class<? extends Module>... expectedModules) {

        final ModulesMetadata modulesMetadata = runtime.getInstance(ModulesMetadata.class);

        final List<String> actualModules = modulesMetadata
                .getModules()
                .stream()
                .map(ModuleMetadata::getName)
                .collect(toList());

        final String[] expectedModuleNames = new String[expectedModules.length];
        for (int i = 0; i < expectedModules.length; i++) {
            expectedModuleNames[i] = expectedModules[i].getSimpleName();
        }

        // Using class names for checking module existing - weak.
        assertThat(actualModules, hasItems(expectedModuleNames));
    }
}
