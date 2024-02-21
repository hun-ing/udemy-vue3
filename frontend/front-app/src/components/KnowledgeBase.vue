<template>
  <section>
    <h2>Select a Topic</h2>
    <KnowledgeGrid @select-topic="selectTopic"></KnowledgeGrid>
  </section>
</template>

<script setup>
import KnowledgeGrid from "@/components/KnowledgeGrid.vue";

const emits = defineEmits(['select-topic']);
const selectTopic = (topicId) => emits('select-topic', topicId);
</script>