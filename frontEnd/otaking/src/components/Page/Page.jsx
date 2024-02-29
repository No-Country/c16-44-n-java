"use client"
import '@/components/Page/Page.css'

export default function Page({
  children
}) {
  return (
    <div className="page">
      {children}
    </div>
  )
}