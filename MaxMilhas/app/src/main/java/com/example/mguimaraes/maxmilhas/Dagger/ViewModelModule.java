package com.example.mguimaraes.maxmilhas.Dagger;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.mguimaraes.maxmilhas.ViewModels.OutboundFlightsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface ViewModelModule {

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(OutboundFlightsViewModel.class)
    ViewModel bindOutboundFlightsViewModel(OutboundFlightsViewModel viewModel);

}
