<template>
  <section>
    <h2>{{ topicTitle }}</h2>
    <p>{{ text }}</p>
  </section>
</template>

<script setup>
defineProps(['topicTitle', 'text']);
</script>