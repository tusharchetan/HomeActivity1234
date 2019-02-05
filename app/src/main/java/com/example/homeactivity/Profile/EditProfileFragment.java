package com.example.homeactivity.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.homeactivity.R;
import com.example.homeactivity.utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {
    private ImageView mProfilePhoto;
    private ImageView backProfile;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);
        setupImageLoader();
        setProfileImage();
        backProfile = view.findViewById(R.id.backArrow);
        backProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
    private void setupImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
    private void setProfileImage()
    {
        UniversalImageLoader.setImage("https://i.ytimg.com/vi/WyGSHUrEeCc/hqdefault_live.jpg",mProfilePhoto,null,"");
    }
}
