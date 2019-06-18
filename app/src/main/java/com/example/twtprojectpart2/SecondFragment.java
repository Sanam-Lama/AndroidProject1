package com.example.twtprojectpart2;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }

    ImageView image_view;
    SeekBar seek_bar;
    ArrayList<Integer> images = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        image_view = (ImageView)view.findViewById(R.id.imageView);
        seek_bar = (SeekBar)view.findViewById(R.id.seekBar);

        // adding icons to the arraylist of icons for generating random icons when seekbar is pressed
        images.add(android.R.drawable.ic_btn_speak_now);
        images.add(android.R.drawable.ic_delete);
        images.add(android.R.drawable.ic_menu_upload);
        images.add(android.R.drawable.ic_dialog_info);
        images.add(android.R.drawable.ic_btn_speak_now);
        images.add(android.R.drawable.ic_delete);
        images.add(android.R.drawable.ic_menu_upload);
        images.add(android.R.drawable.ic_dialog_info);

        /* When Tab two is clicked, a permission box is displayed */
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    // if the permission is allowed then enters here and generates random icons
                    // random in here is an integer and holds the integer value received from images.size()
                    int random = new Random().nextInt(images.size());

                    // image that is present in the random value is then displayed
                    image_view.setImageResource(images.get(random));

                } else {
                    // if the permission is denied for the first time then enters here
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Log.e("Print", "Show Rationale");

                        /* After the deny box is clicked and the user wants to click the seekbar to proceed, then this snackbar
                         * is executed. Once the user clicks "OK" then permission box displays again. This continues until the
                         * user allows the permission. */

                        final Snackbar snackbar = Snackbar.make(getView(), "Please enable storage permission", Snackbar.LENGTH_INDEFINITE);
                        snackbar.setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, 1);
                                snackbar.dismiss();
                            }
                        });
                        snackbar.show();;
                    }
                    else {
                        // if the permission is denied checking the "Do not ask" then enters here
                        ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, 1);

                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       // super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
        else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                Log.e("Print", "Show Rationale");
            }
            else {
                Toast.makeText(getActivity(), "Never ask again selected.",Toast.LENGTH_LONG).show();
            }

        }
    }
}
