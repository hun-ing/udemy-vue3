<template>
  <ul>
    <KnowledgeElement
      v-for="topic in topics"
      :key="topic.id"
      :id="topic.id"
      :topic-name="topic.title"
      :description="topic.description"
      @select-topic="selectTopic"
    ></KnowledgeElement>
  </ul>
</template>

<script setup>
import KnowledgeElement from "@/components/KnowledgeElement.vue";
import { inject } from 'vue';

const topics = inject('topics')
const emits = defineEmits(['select-topic']);

const selectTopic = (topicId) => emits('select-topic', topicId);
</script>