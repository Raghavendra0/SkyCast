package com.skycast.data.repository;

import com.skycast.data.api.WeatherApi;
import com.skycast.data.db.LocationDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class WeatherRepository_Factory implements Factory<WeatherRepository> {
  private final Provider<WeatherApi> apiProvider;

  private final Provider<LocationDao> daoProvider;

  public WeatherRepository_Factory(Provider<WeatherApi> apiProvider,
      Provider<LocationDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public WeatherRepository get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static WeatherRepository_Factory create(Provider<WeatherApi> apiProvider,
      Provider<LocationDao> daoProvider) {
    return new WeatherRepository_Factory(apiProvider, daoProvider);
  }

  public static WeatherRepository newInstance(WeatherApi api, LocationDao dao) {
    return new WeatherRepository(api, dao);
  }
}
