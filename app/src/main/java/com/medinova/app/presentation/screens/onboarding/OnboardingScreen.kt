package com.medinova.app.presentation.screens.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.medinova.app.presentation.screens.onboarding.viewmodel.OnboardingViewModel
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

    val onboardingPages = listOf(
        OnboardingPage(
            title = "Find Trusted Doctors",
            description = "Search and connect with verified medical professionals from various specialties",
            imageResource = "ic_doctor_search" // You would add these as drawable resources
        ),
        OnboardingPage(
            title = "Book Appointments Easily",
            description = "Schedule video, voice, or in-person consultations at your convenience",
            imageResource = "ic_appointment"
        ),
        OnboardingPage(
            title = "Secure Health Records",
            description = "Keep your medical history and documents safe and accessible anytime",
            imageResource = "ic_health_records"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageContent(
                page = onboardingPages[page],
                modifier = Modifier.fillMaxSize()
            )
        }

        // Page indicators and buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Skip button
            TextButton(
                onClick = {
                    viewModel.completeOnboarding()
                    onFinished()
                }
            ) {
                Text("Skip")
            }

            // Page indicators
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(onboardingPages.size) { index ->
                    PageIndicator(
                        isSelected = pagerState.currentPage == index
                    )
                }
            }

            // Next/Finish button
            Button(
                onClick = {
                    if (pagerState.currentPage == onboardingPages.size - 1) {
                        viewModel.completeOnboarding()
                        onFinished()
                    } else {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                }
            ) {
                Text(
                    if (pagerState.currentPage == onboardingPages.size - 1) 
                        "Get Started" 
                    else 
                        "Next"
                )
            }
        }
    }
}

@Composable
fun OnboardingPageContent(
    page: OnboardingPage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Placeholder for image - in a real app, you'd use AsyncImage or similar
        Card(
            modifier = Modifier
                .size(200.dp)
                .padding(32.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = page.imageResource,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun PageIndicator(
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(8.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier.size(if (isSelected) 8.dp else 6.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSelected) 
                    MaterialTheme.colorScheme.primary 
                else 
                    MaterialTheme.colorScheme.outline
            )
        ) {}
    }
}

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageResource: String
)