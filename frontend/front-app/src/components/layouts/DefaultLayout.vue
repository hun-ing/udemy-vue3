<template>
  <TheNav />
  <TheHeader />

  <v-main>
    <v-container fluid>
      <v-card
        class="mb-3"
        variant="flat"
      >
        <v-row
          justif="space-between"
          align="center"
        >
          <v-col align-self="center">
            <p class="text-h5 font-weight-medium">
              공지사항
            </p>
          </v-col>
          <v-breadcrumbs :items="items">
            <template #divider>
              <v-icon icon="mdi-chevron-right" />
            </template>
          </v-breadcrumbs>
        </v-row>
      </v-card>

      <router-view v-slot="slotProps">
        <transition
          name="route"
          mode="out-in"
        >
          <component :is="slotProps.Component" />
        </transition>
      </router-view>
    </v-container>
  </v-main>
</template>

<script setup>
import TheNav from '@/components/layouts/TheNav.vue'
import TheHeader from '@/components/layouts/TheHeader.vue'
import { ref } from 'vue'

const items = ref([
  {
    title: 'Dashboard',
    disabled: false,
    href: 'breadcrumbs_dashboard'
  },
  {
    title: 'Link 1',
    disabled: false,
    href: 'breadcrumbs_link_1'
  },
  {
    title: 'Link 2',
    disabled: true,
    href: 'breadcrumbs_link_2'
  }
])
</script>