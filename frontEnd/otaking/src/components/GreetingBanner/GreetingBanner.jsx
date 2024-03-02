'use client'
import { Swiper, SwiperSlide } from 'swiper/react';
import { Pagination, Navigation } from "swiper/modules";
import './GreetingBanner.css';
import 'swiper/css';
import 'swiper/css/pagination';
import 'swiper/css/navigation';

export default function GreetingBanner() {
  return <article className="greeting-banner">
    <div className='greeting-banner__mssg'>
      <h2 className='greeting-banner__title'>Descubre los productos otaku</h2>
      <p className='greeting-banner__text'>Bienvenido al bazar de tus productos favoritos. Registrate y podrás comprar o vender aquí!</p>
    </div>
    <Swiper className='greeting-banner__swiper' pagination={{type: 'fraction'}} navigation={true} modules={[Pagination, Navigation]}>
      <SwiperSlide><img className='greeting-banner__img' src="/images/aaron-cass.jpg" /></SwiperSlide>
      <SwiperSlide><img className='greeting-banner__img greeting-banner__img_opacity' src='/images/pexels-kimmi-jun.jpg'/></SwiperSlide>
    </Swiper>
  </article>
}