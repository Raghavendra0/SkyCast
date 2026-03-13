package com.skycast.di;

import com.skycast.data.db.AppDatabase;
import com.skycast.data.db.LocationDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideLocationDaoFactory implements Factory<LocationDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideLocationDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public LocationDao get() {
    return provideLocationDao(databaseProvider.get());
  }

  public static AppModule_ProvideLocationDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideLocationDaoFactory(databaseProvider);
  }

  public static LocationDao provideLocationDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLocationDao(database));
  }
}
