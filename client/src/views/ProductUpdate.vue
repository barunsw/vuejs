<template>
  <div>
    <main class="mt-3">
        <div class="container">
            <h2 class="text-center">제품 수정</h2>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품명</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" v-model="productDetail.productName">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품가격</label>
                <div class="col-md-9">
                    <div class="input-group">
                        <input type="number" class="form-control" v-model="productDetail.productPrice">
                        <span class="input-group-text">원</span>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">배송비</label>
                <div class="col-md-9">
                    <div class="input-group">
                        <input type="number" class="form-control" v-model="productDetail.deliveryPrice">
                        <span class="input-group-text">원</span>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">추가배송비(도서산간)</label>
                <div class="col-md-9">
                    <div class="input-group">
                        <input type="number" class="form-control" v-model="productDetail.addDeliveryPrice">
                        <span class="input-group-text">원</span>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">제품카테고리</label>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-auto">
                            <select class="form-select">
                                <option>전자제품</option>
                            </select>
                        </div>
                        <div class="col-auto">
                            <select class="form-select">
                                <option>컴퓨터</option>
                            </select>
                        </div>
                        <div class="col-auto">
                            <select class="form-select">
                                <option>악세사리</option>
                            </select>        
                        </div>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">태그</label>
                <div class="col-md-9">
                    <input type="text" class="form-control" v-model="productDetail.tags">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-md-3 col-form-label">출고일</label>
                <div class="col-md-9">
                    <div class="input-group">
                        <input type="number" class="form-control" v-model="productDetail.outboundDays">
                        <span class="input-group-text">일 이내 출고</span>
                    </div>
                </div>
            </div>
            <div class="mb-3 row">
                <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-dark" @click="goToList()">취소하기</button>
                </div>
                <div class="col-6 d-grid p-1">
                    <button type="button" class="btn btn-lg btn-danger">저장하기</button>
                </div>
            </div>
        </div>
    </main>
  </div>
</template>

<script>
export default {
    data() {
        return {
            productId: 0,
            productDetail: {}
        }
    },
    computed: {
        user() {
            return this.$store.state.user;
        }
    },
    mounted() {
        if (this.user.email == undefined) {
            alert('로그인을 해야 이용할 수 있습니다.')
            this.$router.push({path:'/'});
        }
    },
    created() {
        this.productId = this.$route.query.product_id;
        this.getProductDetail();
    },
    methods: {
        goToList() {
            this.$router.push({path: '/sales'})
        },
        async getProductDetail() {
            let result = await this.$api("/api/product/detail/" + this.productId, "GET", {});
            if (result != null && result.data.length > 0) {
                this.productDetail = result.data[0];
            }
        }
    }
}
</script>
