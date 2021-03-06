package org.robolectric.shadows;

import android.content.res.ApkAssets;
import android.os.Build;
import com.android.internal.util.Preconditions;
import java.io.IOException;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(value = ApkAssets.class, minSdk = Build.VERSION_CODES.P, isInAndroidSdk = false)
public class ShadowApkAssets {
  private String assetPath;

  @Implementation
  protected void __constructor__(String path, boolean system, boolean forceSharedLib,
      boolean overlay) throws IOException {
    Preconditions.checkNotNull(path, "path");
    assetPath = path;
  }

  @Implementation
  protected String getAssetPath() {
    return assetPath;
  }
}
