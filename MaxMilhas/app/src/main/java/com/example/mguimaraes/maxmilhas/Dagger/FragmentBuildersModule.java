package com.example.mguimaraes.maxmilhas.Dagger;

import com.example.mguimaraes.maxmilhas.Fragments.OutboundFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    OutboundFragment contributeOutboundFragment();

}
