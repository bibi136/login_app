package com.example.framgia.login_app;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class EasyPermissionActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private final static int REQUEST_PERMISSION_CAMERA = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_permission);
        findViewById(R.id.btnRequirePermission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodRequiresPermission();
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d("hung", "onPermissionsGranted: " + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d("hung", "onPermissionsDenied: " + perms.size());
    }

    @AfterPermissionGranted(REQUEST_PERMISSION_CAMERA)
    private void methodRequiresPermission() {
        if (EasyPermissions.hasPermissions(
                this, Manifest.permission.CAMERA)) {
            Log.d("hung", "methodRequiresPermission: Already have permission");
        } else {
            EasyPermissions.requestPermissions(
                    this,
                    "This app needs to access your camera",
                    REQUEST_PERMISSION_CAMERA,
                    Manifest.permission.CAMERA);
        }
    }

}
