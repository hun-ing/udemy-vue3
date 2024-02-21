<template>
  <li>
    <h3>{{ topicName }}</h3>
    <p>{{ description }}</p>
    <button @click="selectTopic(id)">Learn More</button>
  </li>
</template>

<script setup>
import {inject} from "vue";

const selectTopic = inject('selectTopic');

const props = defineProps(['id', 'topicName', 'description']);
// const emits = defineEmits(['select-topic']);
// const selectTopic = () => emits('select-topic', props.id);
</script>