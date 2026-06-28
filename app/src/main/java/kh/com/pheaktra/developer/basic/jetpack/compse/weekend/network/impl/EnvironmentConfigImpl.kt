package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.impl

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.BuildConfig
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.EnvironmentConfig

class EnvironmentConfigImpl : EnvironmentConfig {
    override val baseUrl: String = BuildConfig.BASE_URL
    override val basePort: String = BuildConfig.BASE_PORT
    override val environment: String = BuildConfig.ENVIRONMENT
}