package ru.coffeestudio.foodinthecold.util

import ru.coffeestudio.foodinthecold.db.entities.ProductEntity
import ru.coffeestudio.foodinthecold.model.Product
import ru.coffeestudio.foodinthecold.model.ProductSimple

fun productToProductEntity(pr: Product): ProductEntity {
    return ProductEntity(
        id = pr.id,
        title = pr.title,
        description = pr.description,
        image = pr.image,
        imagePreview = pr.imagePreview,
        productCode = pr.productCode,
        barcode = pr.barcode,
        vendorCode = pr.vendorCode,
        weight = pr.weight,
        length = pr.length,
        width = pr.width,
        height = pr.height,
        volume = pr.volume,
        quantity = pr.quantity,
        priceBase = pr.priceBase,
        price = pr.price,
        discount = pr.discount)
}

fun productToProductSimple(pr: Product): ProductSimple {
    return ProductSimple(
        id = pr.id,
        title = pr.title,
        description = pr.description,
        imagePreview = pr.imagePreview,
        productCode = pr.productCode,
        barcode = pr.barcode,
        vendorCode = pr.vendorCode,
        quantity = pr.quantity,
        priceBase = pr.priceBase,
        price = pr.price,
        discount = pr.discount)
}

fun productEntityToProduct(pe: ProductEntity): Product {
    return Product(
        id = pe.id,
        title = pe.title,
        description = pe.description,
        image = pe.image,
        imagePreview = pe.imagePreview,
        productCode = pe.productCode,
        barcode = pe.barcode,
        vendorCode = pe.vendorCode,
        weight = pe.weight,
        length = pe.length,
        width = pe.width,
        height = pe.height,
        volume = pe.volume,
        quantity = pe.quantity,
        priceBase = pe.priceBase,
        price = pe.price,
        discount = pe.discount)
}

fun productEntityToProductSimple(pe: ProductEntity): ProductSimple {
    return ProductSimple(
        id = pe.id,
        title = pe.title,
        description = pe.description,
        imagePreview = pe.imagePreview,
        productCode = pe.productCode,
        barcode = pe.barcode,
        vendorCode = pe.vendorCode,
        quantity = pe.quantity,
        priceBase = pe.priceBase,
        price = pe.price,
        discount = pe.discount,
        sort = pe.sort)
}

fun productSimpleToProductEntity(ps: ProductSimple): ProductEntity {
    return ProductEntity(
        id = ps.id,
        title = ps.title,
        description = ps.description,
        imagePreview = ps.imagePreview,
        productCode = ps.productCode,
        barcode = ps.barcode,
        vendorCode = ps.vendorCode,
        quantity = ps.quantity,
        priceBase = ps.priceBase,
        price = ps.price,
        discount = ps.discount)
}

