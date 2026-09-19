package com.today.eggs.ui.screen

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.today.eggs.feature.calendar.api.CalendarRoute
import com.today.eggs.feature.calendar.impl.CalendarScreen
import com.today.eggs.feature.home.api.HomeRoute
import com.today.eggs.feature.home.impl.HomeScreen
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.today.eggs.ui.MainTab

@Composable
fun EggsNavigationWrapperUI() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            MainTab.entries.forEach { tab ->
                item(
                    selected = currentDestination?.hierarchy?.any {
                        it.hasRoute(tab.route)
                    } == true,
                    onClick = {
                        navController.navigate(tab.routeInstance) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(tab.icon, contentDescription = null) },
                    label = { Text(stringResource(tab.titleRes)) }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
        ) {
            composable<HomeRoute> {
                HomeScreen()
            }
            composable<CalendarRoute> {
                CalendarScreen()
            }
        }
    }
}