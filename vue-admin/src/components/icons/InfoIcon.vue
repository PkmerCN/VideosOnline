<script setup lang="ts">
import { IconProps } from '@/composables/useIconProps'

const { width, height } = withDefaults(defineProps<IconProps>(), {
  width: 35,
  height: 35
})
</script>

<template>
  <svg t="1718529389152" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
       p-id="7527" :width :height>
    <path
      d="M512 64C264.6 64 64 264.6 64 512s200.6 448 448 448 448-200.6 448-448S759.4 64 512 64z m0 820c-205.4 0-372-166.6-372-372s166.6-372 372-372 372 166.6 372 372-166.6 372-372 372z"
      p-id="7528"></path>
    <path d="M512 336m-48 0a48 48 0 1 0 96 0 48 48 0 1 0-96 0Z" p-id="7529"></path>
    <path d="M536 448h-48c-4.4 0-8 3.6-8 8v272c0 4.4 3.6 8 8 8h48c4.4 0 8-3.6 8-8V456c0-4.4-3.6-8-8-8z"
          p-id="7530"></path>
  </svg>
</template>
