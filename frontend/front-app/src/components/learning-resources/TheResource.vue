<template>
  <BaseCard>
    <BaseButton @click="setSelectedTab(StoredResources)" :mode="storedResButtonMode">Stored Resources</BaseButton>
    <BaseButton @click="setSelectedTab(AddResource)" :mode="addResButtonMode">Add Resource</BaseButton>
  </BaseCard>
  <component :is="selectedTab"></component>
</template>

<script setup>
import {ref, provide, computed} from "vue";
import StoredResources from "@/components/learning-resources/StoredResources.vue";
import AddResource from "@/components/learning-resources/AddResource.vue";

const selectedTab = ref(StoredResources);

const resources = ref([
  {id: 'test1', title: 'Test1', description: 'test111', link: 'https://vuejs.org'},
  {id: 'test2', title: 'Test2', description: 'test222', link: 'https://google.org'},
]);

provide('resources', resources);
const setSelectedTab = (tab) => {
  selectedTab.value = tab;
}

console.log('selectedTab.value = ', selectedTab.value);
console.log('StoredResources = ', StoredResources);

const storedResButtonMode = computed(() => selectedTab.value.__name === StoredResources.__name ? null : 'flat');
const addResButtonMode = computed(() => selectedTab.value.__name === AddResource.__name ? null : 'flat');
</script>

<style scoped>

</style>