<template>
  <section>
    <BaseCard>
      <template #header>
        <h3>{{ fullName }}</h3>
        <BaseBadge :type="role" :caption="role.toUpperCase()"></BaseBadge>
      </template>
      <template #default>
        <p>{{ infoText }}</p>
      </template>
    </BaseCard>
  </section>
</template>

<script setup>
import BaseBadge from "@/components/BaseBadge.vue";

defineProps(['fullName', 'infoText', 'role'])
</script>