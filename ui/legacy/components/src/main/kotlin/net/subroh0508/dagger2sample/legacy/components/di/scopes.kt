package net.subroh0508.dagger2sample.legacy.components.di

import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope
