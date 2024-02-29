import {useProductStore} from "@/stores/product/index.js";

export default {
    addProductToCart(prodId) {
        let prodData = this.items.find(item => item.productId === prodId);

        if (!prodData) {
            const productStore = useProductStore();
            prodData = productStore.getProductById(prodId);

            const newItem = {
                productId: prodData.id,
                title: prodData.title,
                image: prodData.image,
                price: prodData.price,
                qty: 1,
            };
            this.items.push(newItem);
        } else {
            prodData.qty++;
        }

        this.qty++;
        this.total += prodData.price;
    },
    removeProductFromCart(prodId) {
        const productInCartIndex = this.items.findIndex(
            (cartItem) => cartItem.productId === prodId
        );
        const prodData = this.items[productInCartIndex];
        this.items.splice(productInCartIndex, 1);
        this.qty -= prodData.qty;
        this.total -= prodData.price * prodData.qty;
    }
}