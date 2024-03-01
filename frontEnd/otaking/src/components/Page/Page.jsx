"use client"
import '@/components/Page/Page.css'
import Header from '../Header/Header'


export default function Page({
  children
}) {
  return (
    <div className="page">
      <Header />
      {children}
    </div>
  )
}