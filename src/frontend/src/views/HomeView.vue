<template>
  <div class="home">
    <!-- Add Book Form -->
    <el-form @submit.native.prevent="submitBook">
      <el-form-item label="Title" prop="title">
        <el-input v-model="book.title" required></el-input>
      </el-form-item>

      <el-form-item label="Author" prop="author">
        <el-input v-model="book.author" required></el-input>
      </el-form-item>

      <el-form-item label="Price" prop="price">
        <el-input v-model.number="book.price" required></el-input>
      </el-form-item>

      <el-form-item label="Number" prop="num">
        <el-input v-model.number="book.num" required></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" native-type="submit">Submit</el-button>
      </el-form-item>
    </el-form>

    <!-- Search Form -->
    <el-form @submit.native.prevent="searchBook">
      <el-form-item label="Search Title">
        <el-input v-model="searchTitle" required></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" native-type="submit">Search</el-button>
      </el-form-item>
    </el-form>

    <!-- Display Search Results -->
    <div v-if="searchResults.length > 0">
      <h2>Search Results:</h2>
      <ul>
        <li v-for="(book, index) in searchResults" :key="index">
          {{ book.title }} by {{ book.author }} - ${{ book.price }} ({{ book.num }} available)
        </li>
      </ul>
    </div>
  </div>
</template>


<script>
import axios from 'axios';

export default {
  data() {
    return {
      book: {
        title: '',
        author: '',
        price: 0,
        num: 0
      },
      searchTitle: '',
      searchResults: []
    };
  },
  methods: {
    submitBook() {
      // Send book data to the backend using Axios
      axios.post('/api/book/add', this.book)
        .then(response => {
          if (response.status === 200) {
            this.$message.success('Book submitted successfully!');
            // Clear form
            this.clearForm();
          } else {
            this.$message.error('Failed to submit book.');
          }
        })
        .catch(error => {
          console.error('Error submitting book:', error);
          this.$message.error('Failed to submit book.');
        });
    },
    clearForm() {
      // Clear form data
      this.book = {
        title: '',
        author: '',
        price: 0,
        num: 0
      };
    },
    searchBook() {
      // Send search query to the backend using Axios
      axios.get('api/book/search', {
        params: {
          title: this.searchTitle
        }
      })
        .then(response => {
          this.searchResults = response.data;
        })
        .catch(error => {
          console.error('Error searching book:', error);
          this.searchResults = [];
        });
    }
  }
}
</script>
