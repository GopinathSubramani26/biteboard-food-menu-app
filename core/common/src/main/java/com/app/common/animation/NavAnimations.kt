package com.app.common.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut

fun fadeOutTransition() = fadeOut(tween(300, easing = LinearEasing))

fun fadeInTransition() = fadeIn(tween(300, easing = LinearEasing))